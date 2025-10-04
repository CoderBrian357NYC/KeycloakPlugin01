package com.brian.keycloak;

import org.keycloak.events.Event;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.Config;
import org.keycloak.models.KeycloakSessionFactory;

public class MyPlugin implements EventListenerProvider {

    private final KeycloakSession session;

    public MyPlugin(KeycloakSession session) {
        this.session = session;
    }

    // User events
    @Override
    public void onEvent(Event event) {
        switch (event.getType()) {
            case LOGIN:
                System.out.println("[MyPlugin] LOGIN SUCCESS: User " + event.getUserId() + " from IP " + event.getIpAddress());
                break;
            case LOGIN_ERROR:
                System.out.println("[MyPlugin] LOGIN FAILURE: User " + event.getUserId() + " / Username=" + event.getDetails().get("username") + " from IP " + event.getIpAddress() + ", Error=" + event.getError());
                break;
            case LOGOUT:
                System.out.println("[MyPlugin] LOGOUT: User " + event.getUserId() + " from IP " + event.getIpAddress());
                break;
            default:
                System.out.println("[MyPlugin] Other User Event: " + event.getType() + ", User=" + event.getUserId() + ", IP=" + event.getIpAddress());
        }
    }

    // Admin events
    @Override
    public void onEvent(AdminEvent adminEvent, boolean includeRepresentation) {
        System.out.println("[MyPlugin] Admin Event received: " + adminEvent.getOperationType());
    }

    @Override
    public void close() { }

    public static class Factory implements EventListenerProviderFactory {

        @Override
        public EventListenerProvider create(KeycloakSession session) {
            System.out.println("[MyPlugin Factory] Creating EventListener for session: " + session);
            return new MyPlugin(session);
        }

        @Override
        public void init(Config.Scope config) { }

        @Override
        public void postInit(KeycloakSessionFactory factory) { }

        @Override
        public void close() { }

        @Override
        public String getId() {
            return "my-plugin";
        }
    }
}
