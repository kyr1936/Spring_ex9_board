# Spring_ex9_board



# 1. Project Setting

## 1) Encoding
####  a. web.xml EncodingFileter 등록

## 2) Library Setting (API) (pom.xml)
####  a. springframework 4. . .이상
####  b. Mybatis
####		- mybatis
####		- spring-mybatis
####		- spring-jdbc
####		- ojdbc
####  c. fileUpload
#### 		- commons-fileupload(commons-io)
####  d. JunitTest
####		- JUNIT version 4.12 이상
####		- spring-test

## 3) JUNIT Test 설정
####	a.src/test/java
#####		- 기본 패키지 내에 AbstractTest junit Test cast 작성
#####		- 클래스 선언부애 
#####		@RunWith(SpringJUnit4ClassRunner.class)
#####		@ContextConfiguration(locations = 
#####		{"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
#####		- 다른 junit test case 생성해서 상속 받아서 사용



## 4) XML 파일 설정
####	a. server-context.xml
####	b. root-context.xml
#####			- mybatis
#####			1) connection - properties 파일 사용 : DriverManagerDataSource
#####			2) connection, xml : SqlSessionFactoryBean
#####			3) 최종 mapping : SqlSessionTemplate

#####			- fileUpload
#####			 	: 여러 개의 file들을 하나로 합쳐주는 객체 : CommonsMultipartResolver

#####			- properties 파일 위치 설정
#####				: PropertyPlaceholderConfigurer

## 5) Mybatis 설정 
####	- file들의 위치
#####			src/main/resources 하위에  myBatis 디렉터리 생성
#####			myBatis 하위에 폴더 생성
#####			1) config : mybatis 설정 파일들
#####			2) mappers : mybatis sql 파일들










