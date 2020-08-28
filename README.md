# test_user_emails

Алгоритм выполняет слияние пользователей по email'ам.
Сначала вводится колличество пользователей. Затем, через запятую, указываются emails для каждого пользователя.

Например: 
Enter a number of users: 5

user1 -> xxx@ya.ru, foo@gmail.com, lol@mail.ru
user2 -> foo@gmail.com, ups@pisem.net
user3 -> xyz@pisem.net, vasya@pupkin.com
user4 -> ups@pisem.net, aaa@bbb.ru
user5 -> xyz@pisem.net

После работы алгоритма выводятся пользователи с уникальными email'ами.

Result:
user1 -> aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com
user3 -> vasya@pupkin.com, xyz@pisem.net
