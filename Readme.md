## Обучение OTUS QA.Java.Professional

### Stub & Api Testing (API-helpers)
#### Задание
Необходимо реализовать Stub сервер на Wiremock со следующими endpoint'ами:
1. /user/get/{id} - для получения оценки пользователя
2. /cource/get/all - для получения списка курсов
3. /user/get/all - для получения списка всех пользователей

Создать "хелперы" (API-helpers) для работы с API
1. создать тест с http-helper
2. создать тест с soap-helper

#### Описание реализации
В проекте иcпользуется Java 8 и Citrus

#### Запуск
1. HTTP-helper: clean test -Dtest=HTTP_Test verify
2. SOAP-helper: clean test -Dtest=SOAP_Test verify