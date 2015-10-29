/**
 * Created by onder.dal on 29.10.2015.
 */
Ext.define('BigWebAppUI.view.main.Viewport', {
    extend: 'Ext.Container',

    requires: [
        'BigWebAppUI.view.main.viewport.ViewportController',
        'BigWebAppUI.view.main.viewport.ViewportModel',
        'Ext.form.field.ComboBox',
        'Ext.layout.container.Border',
        'Ext.layout.container.Fit',
        'Ext.layout.container.VBox',
        'Ext.panel.Panel',
        'Ext.tab.Panel',
        'Ext.tab.Tab',
        'Ext.tree.Panel',
        'Ext.plugin.Viewport'
    ],

    /*
    Uncomment to give this component an xtype
    xtype: 'viewport',
    */

    viewModel: {
        type: 'viewport'
    },

    controller: 'viewport',

    layout: 'border',

    id: 'mainViewPort',

    items: [

        {
            xtype: 'tabpanel',
            region: 'center',
            title: 'Main Tab Panel',
            id: 'mainTabPanel',
            itemId: 'mainTabPanel',
            closable: true,
            header: false,
            activeTab: 0,
            items: [
                {
                    xtype: 'panel',
                    border: false,
                    frame: true,
                    id: 'dashboard',
                    layout: 'fit',
                    bodyBorder: true,
                    title: 'language.Dashboard',
                    tabConfig: {
                        xtype: 'tab',
                        glyph: 'xf015@FontAwesome'
                    }
                }
            ]
        },
        {
            xtype: 'panel',
            region: 'west',
            split: true,
            itemId: 'menuPanel',
            width: 250,
            collapsible: true,
            header: false,
            title: 'language.Menu',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [
                {
                    xtype: 'treepanel',
                    flex: 1,
                    border: false,
                    header: false,
                    title: 'Menü Tree',
                    emptyText: 'YOK'
                }
            ],
            dockedItems: [
                {
                    xtype: 'combobox',
                    flex: 1,
                    dock: 'top',
                    itemId: 'cmbMainMenu',
                    hideTrigger: true,
                    queryDelay: 1000,
                    className: 'com.akgun.kys.model.kys.Menuler',
                    params: {
                        yeniMenu: true
                    }
                }
            ]
        },
        {
            xtype: 'panel',
            collapseMode: 'mini',
            region: 'north',
            split: true,
            frame: true,
            height: 35,
            maxHeight: 35,
            minHeight: 35,
            collapsed: false,
            collapsible: true,
            header: false,
            title: 'Header Panel',
            items: [

            ]
        }

    ]
});