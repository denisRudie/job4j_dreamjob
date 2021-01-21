## Dream Job
[![Build Status](https://travis-ci.com/denisRudie/job4j_dreamjob.svg?branch=master)](https://travis-ci.com/denisRudie/job4j_dreamjob)
### О проекте
Проект по изучению сервлетов.
### Technologies
* Java 14
* Java EE Servlets
* Apache Tomcat
* Postgres
* JS, AJAX, JSP, HTML (front)
* Logging system Slf4j with log4j
* Mockito with PowerMock for test cases
* Maven as a build system
### Возможности
* Авторизация/регистрация. Учетные данные хранятся в БД. Без авторизации ограничен доступ к некоторым страницам с помощью фильтра. При успешной аутентификации имя пользователя сохраняется в сессии.
* Создание/редактирование кандидатов. Загрузка изображений. Данные по кандидатам хранятся в БД. Картинки хранятся в Tomcat.
### Demo
Login page
![ScreenShot](images/loginPage.jpg)

Registration page
![ScreenShot](images/registerPage.jpg)

Candidates list
![ScreenShot](images/candidatesList.jpg)

Candidate creating page
![ScreenShot](images/creatingCandidatePage.jpg)

Candidate editing page
![ScreenShot](images/editCandidatePage.jpg)

