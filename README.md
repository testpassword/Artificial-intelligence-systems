# Лабораторная работа №1 - Генеалогическое дерево на Prolog

Требования:
1. Не менее 4-х поколений
2. Не менее 20 родственников
3. Не менее 10 правил

# Лабораторная работа №2 - Изучение алгоритмов поиска
**Вариант 4**

_Цель задания: Исследование алгоритмов решения задач методом поиска._

Этап 1. Неинформированный поиск. На этом этапе известна только
топология связей между городами. Выполнить:
1) поиск в ширину;
2) поиск глубину;
3) поиск с ограничением глубины;
4) поиск с итеративным углублением;
5) двунаправленный поиск.
Отобразить движение по дереву на его графе с указанием сложности
каждого вида поиска. Сделать выводы.

Этап 2. Информированный поиск. Воспользовавшись информацией о
протяженности связей от текущего узла, выполнить:
1) жадный поиск по первому наилучшему соответствию;
2) затем, использую информацию о расстоянии до цели по прямой от
каждого узла, выполнить поиск методом минимизации суммарной оценки
А*.
Отобразить на графе выбранный маршрут и сравнить его сложность с
неинформированным поиском. Сделать выводы.

Расстояние до цели по прямой взять из подходящей географической карты.
Правило выбора варианта задания. Дату рождения подвергнуть следующей
свертке: (ДД + MM) mod 10 + 1 = номер варианта.

# Лабораторная работа №3 - Создание информационной системы на базе семантической сети

_Цель задания: Изучение семантической сети как инструмента создания информационных и обучающих систем, а также исследование методов логического вывода на основе правил._

Содержание работы:
0. Выбрать предметную область. 
1. Выбрать способ представления знаний в семантической сети – реляционный граф или граф с центром в глаголе, а также язык представления знаний, русский или иной. Возможно многоязычное представление знаний.
2. Записать факты, составляющие предметную область в нотации программы ```Semantic```. Рекомендуемый объем базы знаний – не менее 50 фактов.
3. Снабдить базу знаний онтологиями, в т.ч. правилами (не менее 20), позволяющими извлекать новые факты, а также словарями для поддержки диалога на упрощенном естественном языке.
4. Провести тестирование базы знаний, т.е. убедиться в том, что все правила корректно создают новые факты. 

# Лабораторная работа №4 - Работа с нейронными сетями
**Вариант 2**

_Purpose of work: study of the hyperparameters of the neural network, understanding impact of different hyperparameters on accuracy._

There are 2 parts of work in files named `Lab1-Part1` and `Lab1-Part2` respectively. Both parts represent work with collections of training and test data. 
Part 1 represent recognition of basic math functions with illustrations of neural net vision of the functions for training.
Part 2 represent recognition of simple images for making following work.
Data usage represented at https://keras.io/datasets/ and depends on variant.

There are represented such hyperparameters as

•	Layer count

•	Neurons count per layer (actually it’s not hyperparameter but structure parameter)

•	Learn rate

•	Regularization L1 and L2

•	Output layer activation type

•	Layer activation type 

•	Loss function type

•	Epoch count

1. By changing these hyperparameters try to reach max accuracy value(at least 0.95)  for Part2 model with fixed epoch count 20
2. Change 1st hyperparameter’s value from min to max with minimal step depends on your variant 
3. Show impact on result using graphs
4. Describe impact of each hyperparameter on accuracy.
5. Set hyperparameter value back to one which produced max accuracy
6. Repeat 2-5 steps for second hyperparameter
