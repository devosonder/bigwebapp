package org.onderdal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * The type User.
 * @author onder.dal
 */
@Entity
@Table(name = "app_user")
public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_name", unique = true, nullable = false)
    private String loginName;

    @Column(name = "first_name", nullable = false, length = 200)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 200)
    private String lastName;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "role", length = 2000)
    private String role;

    @Column(name = "password_hash", length = 200)
    private String passwordHash;

    @Column(name = "locale")
    private String locale;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "change_password")
    private boolean changePassword = false;

    @Column(name = "failed_logins", nullable = false, length = 1)
    private Integer failedLogins = 0;

    @Column(name = "locked_out_until")
    private ZonedDateTime lockedOutUntil;

    @Column(name = "last_login")
    private ZonedDateTime lastLogin;

    @Column(name = "password_reset_token")
    private String passwordResetToken;

    @Column(name = "password_reset_token_valid_until")
    private ZonedDateTime passwordResetTokenValidUntil;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "auto_open_view")
    private String autoOpenView;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Gets id.
     * @author onder.dal *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     * @author onder.dal *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets login name.
     * @author onder.dal *
     * @return the login name
     */
    public String getLoginName() {
        return this.loginName;
    }

    /**
     * Sets login name.
     * @author onder.dal *
     * @param loginName the login name
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Gets last name.
     * @author onder.dal *
     * @return the last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets last name.
     * @author onder.dal *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     * @author onder.dal *
     * @return the first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets first name.
     * @author onder.dal *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets email.
     * @author onder.dal *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets email.
     * @author onder.dal *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets role.
     * @author onder.dal *
     * @return the role
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Sets role.
     * @author onder.dal *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets password hash.
     * @author onder.dal *
     * @return the password hash
     */
    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     * Sets password hash.
     * @author onder.dal *
     * @param passwordHash the password hash
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Is enabled.
     * @author onder.dal *
     * @return the boolean
     */
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * Sets enabled.
     * @author onder.dal *
     * @param enabled the enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets locale.
     * @author onder.dal *
     * @return the locale
     */
    public String getLocale() {
        return this.locale;
    }

    /**
     * Sets locale.
     * @author onder.dal *
     * @param locale the locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * Is change password.
     * @author onder.dal *
     * @return the boolean
     */
    public boolean isChangePassword() {
        return changePassword;
    }

    /**
     * Sets change password.
     * @author onder.dal *
     * @param changePassword the change password
     */
    public void setChangePassword(boolean changePassword) {
        this.changePassword = changePassword;
    }

    /**
     * Gets failed logins.
     * @author onder.dal *
     * @return the failed logins
     */
    public Integer getFailedLogins() {
        return this.failedLogins;
    }

    /**
     * Sets failed logins.
     * @author onder.dal *
     * @param failedLogins the failed logins
     */
    public void setFailedLogins(Integer failedLogins) {
        this.failedLogins = failedLogins;
    }

    /**
     * Gets locked out until.
     * @author onder.dal *
     * @return the locked out until
     */
    public ZonedDateTime getLockedOutUntil() {
        return this.lockedOutUntil;
    }

    /**
     * Sets locked out until.
     * @author onder.dal *
     * @param lockedOutUntil the locked out until
     */
    public void setLockedOutUntil(ZonedDateTime lockedOutUntil) {
        this.lockedOutUntil = lockedOutUntil;
    }

    /**
     * Gets last login.
     * @author onder.dal *
     * @return the last login
     */
    public ZonedDateTime getLastLogin() {
        return this.lastLogin;
    }

    /**
     * Sets last login.
     * @author onder.dal *
     * @param lastLogin the last login
     */
    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Gets password reset token.
     * @author onder.dal *
     * @return the password reset token
     */
    public String getPasswordResetToken() {
        return this.passwordResetToken;
    }

    /**
     * Sets password reset token.
     * @author onder.dal *
     * @param passwordResetToken the password reset token
     */
    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    /**
     * Gets password reset token valid until.
     * @author onder.dal *
     * @return the password reset token valid until
     */
    public ZonedDateTime getPasswordResetTokenValidUntil() {
        return this.passwordResetTokenValidUntil;
    }

    /**
     * Sets password reset token valid until.
     * @author onder.dal *
     * @param passwordResetTokenValidUntil the password reset token valid until
     */
    public void setPasswordResetTokenValidUntil(
            ZonedDateTime passwordResetTokenValidUntil) {
        this.passwordResetTokenValidUntil = passwordResetTokenValidUntil;
    }

    /**
     * Gets auto open view.
     * @author onder.dal *
     * @return the auto open view
     */
    public String getAutoOpenView() {
        return this.autoOpenView;
    }

    /**
     * Sets auto open view.
     * @author onder.dal *
     * @param autoOpenView the auto open view
     */
    public void setAutoOpenView(String autoOpenView) {
        this.autoOpenView = autoOpenView;
    }

    /**
     * Is deleted.
     * @author onder.dal *
     * @return the boolean
     */
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * Sets deleted.
     * @author onder.dal *
     * @param deleted the deleted
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
