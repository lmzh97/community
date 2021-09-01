## 资料
[Spring 文档](https://spring.io/guides)  
[Spring Web](https://spring.io/guides/gs/serving-web-content/)  
[Github OAuth](https://docs.github.com/en/developers/apps/building-github-apps/creating-a-github-app)
[Github OAuth改版问题](https://docs.github.com/en/rest/overview/other-authentication-methods)
[Github OAuth改版问题--CSDN示例](https://blog.csdn.net/kuaileky/article/details/104217757)
```sql
CREATE TABLE PUBLIC.user(
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            account_id VARCHAR(100),
                            name VARCHAR(50),
                            token CHAR(36),
                            gmt_create BIGINT,
                            gmt_modified BIGINT
);
```
```sql
create user if not exists sa password '123';
alter user sa admin true;
```
