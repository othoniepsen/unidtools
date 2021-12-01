CREATE TABLE tool (
    tool_id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    link VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (tool_id)
    ) engine=InnoDB DEFAULT charset=utf8;

CREATE TABLE tag (
    tag_id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (tag_id)
    ) engine=InnoDB DEFAULT charset=utf8;
    
CREATE TABLE tool_tag ( 
    tool_id bigint NOT NULL,
    tag_id BIGINT NOT NULL,
    CONSTRAINT FK_tool 
    FOREIGN KEY (tool_id) REFERENCES tool (tool_id),
    CONSTRAINT FK_tag 
    FOREIGN KEY (tag_id) REFERENCES tag (tag_id)
) engine=InnoDB DEFAULT charset=utf8;
        

insert into tool (title, link, description) values ('Notion','https://notion.so' , 'All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized. ')
insert into tool (title, link, description) values ('json-server','https://github.com/typicode/json-server' , 'Fake REST API based on a json schema. Useful for mocking and creating APIs for front-end devs to consume in coding challenges. ')
insert into tool (title, link, description) values ('fastify','https://www.fastify.io/' , 'Extremely fast and simple, low-overhead web framework for NodeJS. Supports HTTP2. ')


insert into tag (name) value ('api')
insert into tag (name) value ('planning')
insert into tag (name) value ('writing')
insert into tag (name) value ('json')
insert into tag (name) value ('node')
insert into tag (name) value ('rest')
insert into tag (name) value ('schema')
insert into tag (name) value ('web')
insert into tag (name) value ('framework')
insert into tag (name) value ('http')


insert into tool_tag (tool_id, tag_id) values (1, 1)
insert into tool_tag (tool_id, tag_id) values (1, 2)
insert into tool_tag (tool_id, tag_id) values (1, 3)
insert into tool_tag (tool_id, tag_id) values (2, 4)
insert into tool_tag (tool_id, tag_id) values (2, 5)
insert into tool_tag (tool_id, tag_id) values (2, 6)
insert into tool_tag (tool_id, tag_id) values (2, 7)
insert into tool_tag (tool_id, tag_id) values (3, 5)
insert into tool_tag (tool_id, tag_id) values (3, 8)
insert into tool_tag (tool_id, tag_id) values (3, 9)
