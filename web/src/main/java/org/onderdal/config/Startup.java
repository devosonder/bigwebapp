package org.onderdal.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.db.DBAppender;
import ch.qos.logback.core.db.DataSourceConnectionSource;
import org.onderdal.entity.Role;
import org.onderdal.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.sql.DataSource;

/**
 * The type Startup.
 * @author onder.dal
 */
@Service("startup")
class Startup {

	private final DataSource primaryDataSource;

	private final PasswordEncoder passwordEncoder;

	private final EntityManager entityManager;

	/**
	 * Instantiates a new Startup.
	 *
	 * @param dataSource the data source
	 * @param passwordEncoder the password encoder
	 * @param transactionTemplate the transaction template
	 * @param entityManagerFactory the entity manager factory
     */
	@Autowired
	public Startup(DataSource dataSource,
				   PasswordEncoder passwordEncoder, TransactionTemplate transactionTemplate, EntityManagerFactory entityManagerFactory) {
		this.primaryDataSource = dataSource;
		this.passwordEncoder = passwordEncoder;
		this.entityManager = entityManagerFactory.createEntityManager();


		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		init();
		tx.commit();
	}

	private void init() {

		configureLog();

		Integer userCount = Integer.valueOf(entityManager.createQuery("select count(*) from User").getSingleResult().toString());
		if (userCount < 1) {

			User adminUser = new User();
			adminUser.setLoginName("admin@bigwebapp.com");
			adminUser.setEmail("admin@bigwebapp.com");
			adminUser.setFirstName("admin");
			adminUser.setLastName("admin");
			adminUser.setLocale("en");
			adminUser.setPasswordHash(this.passwordEncoder.encode("admin"));
			adminUser.setEnabled(true);
			adminUser.setDeleted(false);
			adminUser.setRole(Role.ADMIN.name());
			entityManager.persist(adminUser);
		}

	}

	private void configureLog() {

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		ch.qos.logback.classic.Logger logger = lc.getLogger(Logger.ROOT_LOGGER_NAME);

		if (logger.getAppender("DB") == null) {
			DBAppender appender = new DBAppender();
			appender.setName("DB");
			appender.setContext(lc);

			DataSourceConnectionSource cs = new DataSourceConnectionSource();
			cs.setDataSource(this.primaryDataSource);
			cs.setContext(lc);
			cs.start();

			appender.setConnectionSource(cs);
			appender.start();

			logger.addAppender(appender);
		}

	}

}
