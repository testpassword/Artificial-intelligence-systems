/*
Династия Романовых
Оператор приказывает игнорировать best practice SWI-Prolog-а, запрещающий размещать 
факты разного типа несгрупированными.
*/

:- discontiguous 
    male/1, female/1, 
    married/2, husband/2, wife/2, 
    parent/2, father/2,  mother/2, child/2, son/2, daughter/2,
    sibling/2, brother/2, sister/2,
    grandparent/2, grandfather/2, grandmother/2,
    grandchild/2, grandson/2, granddaughter/2,
    auntOrUncle/2, uncle/2, aunt/2,
    imperor/1.

% rules
married(Husband, Wife) :- Husband @< Wife, married(Wife, Husband). % супруги
% @< предотвращяет бесконечную рекурсию из-за постоянного переставления аргументов
husband(Husband, Wife) :- male(Husband), married(Husband, Wife). % муж
wife(Wife, Husband) :- female(Wife), married(Wife, Husband). % жена
father(Father, Child) :- male(Father), parent(Father, Child). % отец
mother(Mother, Child) :- female(Mother), parent(Mother, Child). % мать
child(Child, Parent) :- parent(Parent, Child). % ребёнок
son(Child, Parent) :- male(Child), child(Child, Parent). % сын
daughter(Child, Parent) :- female(Child), child(Child, Parent). % дочь
sibling(Child1, Child2) :- 
                            father(Father, Child1), father(Parent, Child2),
                            mother(Mother, Child1), mother(Mother, Child2),
                            Child1 \= Child2. % брат или сестра
brother(Brother, Child) :- male(Brother), sibling(Brother, Child). % брат
sister(Sister, Child) :- female(Sister), sibling(Sister, Child). % сестра
grandparent(Grandp, Child) :- parent(Grandp, Parent),  parent(Parent, Child). % прародители
grandfather(Grandf, Child) :- male(Grandf), grandparent(Grandf, Child). % дедушка 
grandmother(Grandm, Child) :- female(Grandm), grandparent(Grandm, Child). % бабушка
grandchild(Child, Grandp) :- grandparent(Grandp, Child). % внук или внучка
grandson(Child, Grandp) :- male(Child), grandchild(Child, Grandp). % внук
granddaughter(Child, Grandp) :- female(Child), grandchild(Child, Grandp). % внучка
auntOrUncle(ParentSibling1, Child) :- sibling(ParentSibling1, ParentSibling2), parent(ParentSibling2, Child). % дядя или тётя
uncle(Uncle, Child) :- male(Uncle), auntoruncle(Uncle, Child). % дядя
aunt(Aunt, Child) :- female(Aunt), auntoruncle(Aunt, Child). % тётя

% facts
male('Михаил Фёдорович').
female('Евдокия Стрешнева').
married('Михаил Фёдорович', 'Евдокия Стрешнева').

male('Алексей Михайлович').
parent('Михаил Фёдорович', 'Алексей Михайлович').
parent('Евдокия Стрешнева', 'Алексей Михайлович').
female('Мария Мирославская').
female('Наталья Нарышкина').
married('Алексей Михайлович', 'Мария Мирославская').
married('Алексей Михайлович', 'Наталья Нарышкина').

male('Фёдор Алексеевич').
parent('Алексей Михайлович', 'Фёдор Алексеевич').
parent('Мария Мирославская', 'Фёдор Алексеевич').
female('Софья Алексевна').
parent('Алексей Михайлович', 'Софья Алексевна').
parent('Мария Мирославская', 'Софья Алексевна').

female('Евдокия Лопухина').
male('Петр 1').
parent('Алексей Михайлович', 'Петр 1').
parent('Наталья Нарышкина', 'Петр 1').
female('Екатерина 1').
married('Петр 1', 'Евдокия Лопухина').
married('Петр 1', 'Екатерина 1').

male('Иван 5').
parent('Алексей Михайлович', 'Иван 5').
parent('Мария Мирославская', 'Иван 5').
female('Прасковья Салтыкова').
married('Иван 5', 'Прасковья Салтыкова').

male('Алексей Петрович').
parent('Петр 1', 'Алексей Петрович').
parent('Евдокия Лопухина', 'Алексей Петрович').
female('Анна Петровна').
parent('Петр 1', 'Анна Петровна').
parent('Екатерина 1', 'Анна Петровна').

female('Елизавета Петровна').
parent('Петр 1', 'Елизавета Петровна').
parent('Екатерина 1', 'Елизавета Петровна').

female('Анна Ивановна').
parent('Иван 5', 'Анна Ивановна').
parent('Прасковья Салтыкова', 'Анна Ивановна').

female('Екатерина Ивановна').
parent('Иван 5', 'Екатерина Ивановна').
parent('Прасковья Салтыкова', 'Екатерина Ивановна').

male('Петр 2').
parent('Алексей Петрович', 'Петр 2').

male('Петр 3').
parent('Анна Петровна', 'Петр 3').
female('Екатерина 2', 'Петр 3').
married('Петр 3', 'Екатерина 2').

female('Анна Леопольдовна').
parent('Екатерина Ивановна', 'Анна Леопольдовна').

female('Мария Фёдоровна').
male('Павел 1').
parent('Петр 3', 'Павел 1').
parent('Екатерина 2', 'Павел 1').
married('Павел 1', 'Мария Фёдоровна').

male('Иван 6').
parent('Анна Леопольдовна', 'Иван 6').

male('Николай 1').
parent('Павел 1', 'Николай 1').
parent('Мария Фёдоровна', 'Николай 1').

male('Александр 1').
parent('Павел 1', 'Александр 1').
parent('Мария Фёдоровна', 'Александр 1').

male('Александр 2').
parent('Николай 1', 'Александр 2').

male('Александр 3').
parent('Александр 2', 'Александр 3').

male('Николай 2').
parent('Александр 3', 'Николай 2').

imperor('Михаил Фёдорович').
imperor('Алексей Михайлович').
imperor('Фёдор Алексеевич').
imperor('Петр 1').
imperor('Екатерина 1').
imperor('Иван 5').
imperor('Елизавета Петровна').
imperor('Анна Ивановна').
imperor('Петр 2').
imperor('Петр 3').
imperor('Екатерина 2').
imperor('Павел 1').
imperor('Иван 6').
imperor('Николай 1').
imperor('Александр 1').
imperor('Александр 2').
imperor('Александр 3').
imperor('Николай 2').

% lab defense
murdered('Александр 2').
murdered('Николай 2').
murdered('Павел 1').
orphan(X) :- parent(Y, X), murdered(Y).