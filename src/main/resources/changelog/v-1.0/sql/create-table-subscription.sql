create table subscriptions
(
    id       bigserial    not null,
    subscription varchar(255),
    end_date_time timestamp,
    is_active boolean,
    user_id int8,
    primary key (id)
);

ALTER  TABLE  subscriptions
    ADD  CONSTRAINT  fk_subscriptions_on_users
        FOREIGN  KEY  (user_id)
            REFERENCES  users (id)
            ON  UPDATE  RESTRICT  ON  DELETE  CASCADE  DEFERRABLE  INITIALLY  DEFERRED;