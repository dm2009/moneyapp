package org.moneyproj.rest;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Spring Demo Web Application configuration.
 *
 * @author Dmitriy S
 */
public class MyApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public MyApplication() {
        packages("org.moneyproj.rest");

    }
}
