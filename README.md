# BankingApp with Java

This repository represents a basic banking application, built during the Object Oriented Programming course taken in my third year at the Faculty of Mathematics and Informatics. 

It contains several object types, such as Client, different types of Accounts, Transactions, Cards etc which are connected through the following model:
- Each Client can have multiple Accounts;
- Each Account can only have one associated Card;
- An Account can be of one of the three types: a RON account, an EUR account or a savings account;
- Each Account can have multiple transactions and they are memorised in a list.

So far, the following actions have been implemented:
- Creating accounts, cards, clients and displaying their information;
- There are three types of account actions that can be made: deposits, withdrawals and transfers;
- Each account has its own transaction history which can be viewed upon request;
- Change of currency in transfers between RON and EUR accounts;
- Calculating and extracting commission;
