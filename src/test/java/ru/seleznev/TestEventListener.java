package ru.seleznev;

import org.slf4j.Logger;
import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.LoggerFactory;

public class TestEventListener
        implements PostInsertEventListener, PreUpdateEventListener, PostDeleteEventListener {
    private static final Logger logger = LoggerFactory.getLogger(TestEventListener.class);

    public void onPostInsert(PostInsertEvent postInsertEvent) {
        logger.info("onPostInsert() started");
    }

    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        logger.info("onPostDelete() started");
    }

    public boolean requiresPostCommitHanding(EntityPersister entityPersister) {
        logger.info("requiresPostCommitHanding() started");
        return false;
    }

    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        logger.info("onPreUpdate() started");
        return false;
    }
}
