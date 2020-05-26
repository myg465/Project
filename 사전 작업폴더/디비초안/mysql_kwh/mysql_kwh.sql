-- account
CREATE TABLE account (
	-- seq: 시퀀스 기능을 가지는 고유키는 seq로 지칭하기로 한다
	seq INT AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(255) UNIQUE,
	username VARCHAR(255) UNIQUE,
	password VARCHAR(255),
    email_reception CHAR(1),
    address_new VARCHAR(255) UNIQUE,
    address_old VARCHAR(255) UNIQUE,
    address_detail VARCHAR(255) UNIQUE,
    address_extra VARCHAR(255) UNIQUE,
    address_zipcode INT UNIQUE,
    phone_first INT,
    phone_middle INT,
    phone_last INT,
	birthday VARCHAR(255) UNIQUE,
    point INT
);

CREATE TABLE user_order (
	seq INT AUTO_INCREMENT PRIMARY KEY,
    account_seq INT REFERENCES account (seq),
	date TIMESTAMP,
	number VARCHAR(255),
    -- 주문 이후 해당 상품이 삭제되어도, 이미 주문했던 상품명은 유지되어야 함 (주문 시 상품명 저장)
    product VARCHAR(255),
    -- 주문 이후 해당 상품가격이 바뀌어도, 이미 주문된 물품의 가격은 바뀔 수 없다 (주문 시 가격 저장)
    price INT,
    quantity INT,
    status VARCHAR(255),
    review CHAR(1)
);

CREATE TABLE product_today (
	seq INT AUTO_INCREMENT PRIMARY KEY,
    account_seq INT REFERENCES account (seq),
	product INT REFERENCES product (seq)
);

CREATE TABLE cart (
	seq INT AUTO_INCREMENT PRIMARY KEY,
    account_seq INT REFERENCES account (seq),
	product INT REFERENCES product (seq),
	quantity INT
);

CREATE TABLE coupon (
	name VARCHAR(255),
    content VARCHAR(255)
);

CREATE TABLE user_coupon (
	seq INT AUTO_INCREMENT PRIMARY KEY,
    account_seq INT REFERENCES account (seq),
	coupon_seq INT REFERENCES coupon (seq),
    start_date TIMESTAMP,
    end_date TIMESTAMP
);

CREATE TABLE wishlist (
	seq INT AUTO_INCREMENT PRIMARY KEY,
    account_seq INT REFERENCES account (seq),
	product INT REFERENCES product (seq),
	quantity INT
);

CREATE TABLE point_history (
	seq INT AUTO_INCREMENT PRIMARY KEY,
    account_seq INT REFERENCES account (seq),
    category VARCHAR(255),
	content VARCHAR(255),
    point int,
    status CHAR(1)
);

CREATE TABLE board_inquiry (
	seq INT AUTO_INCREMENT PRIMARY KEY,
    account_seq INT REFERENCES account (seq),
    category VARCHAR(255),
	title VARCHAR(255),
    content VARCHAR(20000),
    filename VARCHAR(255),
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    replied_status CHAR(1),
    reply VARCHAR(20000)
);