Первичная инициализация
=======================
Не требуется, загрузка данных производится средствами спринга на этапе запуска приложения
(schema-mysql.sql и data-mysql.sql).

Примечание : на MySQL сервере должна быть создана бд 'test'. При наличии в ней необходимых
таблиц (hibernate_sequence и part) , они будут удалены и пересозданы с новой "заливкой" данных.

Авторизация для доступа к БД - согл. заданию (root/root).
