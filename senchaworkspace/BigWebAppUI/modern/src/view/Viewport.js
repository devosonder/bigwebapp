/**
 * Created by onder.dal on 29.10.2015.
 */
Ext.define('BigWebAppUI.view.main.viewport.Viewport', {
    extend: 'Ext.Container',

    requires: [
        'BigWebAppUI.view.main.viewport.ViewportController',
        'BigWebAppUI.view.main.viewport.ViewportModel'
    ],

    /*
    Uncomment to give this component an xtype
    xtype: 'viewport',
    */

    viewModel: {
        type: 'viewport'
    },

    controller: 'viewport',

    id: 'mainViewPort',

    items: [

        {html: '<h1>Yapım aşamasında</h1>'}

    ]
});