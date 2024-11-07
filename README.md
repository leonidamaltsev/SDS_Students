SDS Rest API получение информации о студентах

Приложение позволяет, по безопасному протоколу, работать с базой данных студентов, а именно:
 - получать список всех студентов,
 - вносить изменения о студентах из имеющегося списка;
 - добавлять новых студентов;
 - удалять студентов из списка.

Информация о студентах содержащаяся в БД:
1. Фамилия;
2. Имя;
3. Отчество;
4. Группа;
5. Средняя оценка.

Получение пользователей без авторизации:
curl -i http://localhost:8080/all

Регистрация пользователя:
curl -H "Content-Type: application/json" -X POST -d '{
"username": "admin",
"password": "password"
}' http://localhost:8080/users/sign-up

Получение у пользователя token:
curl -i -H "Content-Type: application/json" -X POST -d '{
"username": "admin",
"password": "password"
}' http://localhost:8080/login

Получение всех пользователей с этим токеном:
curl -H "Authorization: Bearer xxx.yyy.zzz" http://localhost:8080/users/all
