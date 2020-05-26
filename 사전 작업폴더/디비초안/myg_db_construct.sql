CREATE TABLE product (
	product_code	varchar(256),
	best	tinyint(1),
    main_view	tinyint(1),
    salenow	tinyint(1),
    sale_ptc double(2,2),
    soldout	tinyint(1),
	product_price	int(8),
    quantity int(5),
	delivery int(5),
    product_total_grade double(2,2),
	product_titleimg varchar(256),
	product_contentimg1 varchar(256),
	product_contentimg2 varchar(256),
	productContentimg3 varchar(256),
    productContent text,
    productCalorie int(10),
    product_type varchar(256),
    product_productor varchar(256),
    product_address varchar(256),
    product_made_date varchar(100),
    product_expiration_date varchar(100),
    product_amount	varchar(130),
    product_meterials text,
    product_gmo varchar(130),
    product_import varchar(130),
    product_tel varchar(100),
    product_category1 varchar(200),
    product_category2 varchar(200),
    point_pct double(2,2),
    product_point int(10),

	primary key(product_code)
);

CREATE TABLE product_qna (
		qna_num int AUTO_INCREMENT,
        qna_category varchar(100),
        product_code varchar(256),
        auth_id varchar(100),
        member_yes tinyint(1),
        auth_ip varchar(256),
        qna_pw varchar(30),
        qna_lock tinyint(1),
        qna_title varchar(256),
        qna_content text,
        qna_hit int(4),
        qna_regdate date,
        qna_update date,
        reply_yes tinyint(1),
        
        primary key(qna_num),
        foreign key(product_code) references product(product_code),
        foreign key(auth_id) references member(id)
);

CREATE TABLE product_photo_review(
		product_photo_review_num int AUTO_INCREMENT,
        buy_yes tinyint(1),
        auth_id varchar(256),
        member_yes tinyint(1),
        auth_ip varchar(256),
        product_code	varchar(256),
        product_category1 varchar(200),
		product_category2 varchar(200),
        product_review_titleimg varchar(256),
        product_grade int(2),
        product_review_title varchar(256),
        product_review_content text,
        product_review_regdate date,
        product_review_update date,
        product_review_hit int(2),
        reply_yes tinyint(1),
        
        primary key(product_photo_review_num),
        foreign key(product_code) references product(product_code),
        foreign key(product_category1) references product(product_category1),
        foreign key(product_category2) references product(product_category2),
        foreign key(auth_id) references member(id)
        
);


CREATE TABLE product_review(
		product_review_num int AUTO_INCREMENT,
        buy_yes tinyint(1),
        auth_id varchar(256),
        member_yes tinyint(1),
        auth_ip varchar(256),
        product_code	varchar(256),
        product_category1 varchar(200),
		product_category2 varchar(200),
        product_grade int(2),
        product_review_title varchar(256),
        product_review_content text,
        product_review_regdate date,
        product_review_update date,
        product_review_hit int(2),
        reply_yes tinyint(1),
        
        primary key(product_review_num),
        foreign key(product_code) references product(product_code),
        foreign key(product_category1) references product(product_category1),
        foreign key(product_category2) references product(product_category2),
        foreign key(auth_id) references member(id)
        
);


CREATE TABLE exprience(
		ex_num int AUTO_INCREMENT,
        apply_start date,
        apply_end date,
        raffle_date date,
        ex_review_start date,
        ex_review_end date,
        apply_person_max int(4),
        ex_title varchar(256),
        ex_content text,
        ex_hit int(4),
        ex_regdate date,
        ex_update date,
        
        
        primary key(ex_num)
);

CREATE TABLE exprience_apply_list(
		apply_num int AUTO_INCREMENT,
        auth_id varchar(256),
        apply_title varchar(256),
        apply_content text,
        apply_regdate date,
        winning tinyint(1),
        cancel tinyint(1),
        
        
        primary key(apply_num),
        foreign key(auth_id) references Member(id)
        
);

CREATE TABLE exprience_review(
		ex_review_num int AUTO_INCREMENT,
        ex_num int(6),
        auth_id varchar(256),
        ex_review_titleimg varchar(256),
        ex_grade int(2),
        ex_review_title varchar(256),
        ex_review_content text,
        ex_review_hit int(4),
        exReview_regdate date,
        exReview_update date,
        reply_yes tinyint(1),
		
        primary key(ex_num),
		foreign key(auth_id) references member(id),
        foreign key(ex_num) references exprience(ex_num)

);

CREATE TABLE enjoy_coffee(
			enjoy_num int AUTO_INCREMENT,
            enjoy_title varchar(256),
            enjoy_content text,
            enjoy_contentimg varchar(256),
            enjoy_regdate date,
            enjoy_hit int(4),

			primary key(enjoy_num)
);

CREATE TABLE reply(
			reply_num int AUTO_INCREMENT,
            reply_board varchar(256),
            reply_boardNum int(6),
            reply_title varchar(256),
            reply_content text,
            reply_name varchar(100),
            reply_regdate date,
            reply_update date,
            
            
            primary key(reply_num)
);

CREATE TABLE member(
            id varchar(256),
            pw varchar(256),


            primary key(id)
);




            
            
            
            


            
            
            
        
        
        


        
        
        
        


