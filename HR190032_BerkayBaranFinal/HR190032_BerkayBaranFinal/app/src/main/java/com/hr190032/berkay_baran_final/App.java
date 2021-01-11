package com.hr190032.berkay_baran_final;

import android.app.Application;

public class App extends Application {
    App app = null;

    public App getApp() {
        if (app == null) {
            app = this;
        }
        return app;
    }
}