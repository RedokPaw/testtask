### Build and run
Для сборки и запуска нужен maven и java.

Windows: запустить run.cmd.

Linux: запустить run.sh.

### Usage
Сервер доступен по адресу: **localhost:8080**

Swagger расположен по дефолт адресу: **localhost:8080/swagger-ui/index.html**

### Description
TL;DR Для сортировки был выбран алгоритм Quickselect из-за его хорошей средней сложности O(n) и простоты.

Cчитаю, что для данной задачи подошёл бы еще способ с использованием min-heap из-за готовой реализации 
в Java PriorityQueue. Есть куда более продвинутые варианты с median-of-medians, introselect или QuickselectAdaptive, 
но это всё оверкил в нашем случае.
Никакие библиотеки и доп. средства для сортировки не использовались, для работы с xlsx взял Apache POI. Excel заполнял 
числами в 1 столбик, мои тестовые данные находятся в src/test/resources.