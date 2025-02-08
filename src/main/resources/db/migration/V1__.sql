CREATE TABLE category
(
    id         BIGINT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    is_deleted BIT(1) NOT NULL,
    cat_title  VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE order_model
(
    id          BIGINT NOT NULL,
    created_at  datetime NULL,
    updated_at  datetime NULL,
    is_deleted  BIT(1) NOT NULL,
    customer_id BIGINT NOT NULL,
    amount      BIGINT NOT NULL,
    order_state VARCHAR(255) NULL,
    CONSTRAINT pk_ordermodel PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    is_deleted    BIT(1) NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    price DOUBLE NOT NULL,
    image_url     VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);