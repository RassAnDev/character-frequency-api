# Character Frequency Api

### Статусы Тестов, Линтера и Поддерживаемости:
[![Java CI](https://github.com/RassAnDev/character-frequency-api/actions/workflows/main.yml/badge.svg)](https://github.com/RassAnDev/character-frequency-api/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/e9d5f8cf1e8d80decdb4/maintainability)](https://codeclimate.com/github/RassAnDev/character-frequency-api/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/e9d5f8cf1e8d80decdb4/test_coverage)](https://codeclimate.com/github/RassAnDev/character-frequency-api/test_coverage)

## О приложении
API, вычисляющее частоту встречи символов в заданной строке, сортируя их по убыванию количества вхождений.

**Формат входящих данных:**
* Входной параметр - строка, в которой нужно вычислить частоту встречи символов;
* Входные данные могут быть переданы в виде JSON-объекта с полем(ключом) "inputString", содержащим строку;
* Входной объект не может быть пустым.

*Пример входящих данных: { "inputString": "fffwwwwwwnll" }*

**Формат исходящих данных:**

* Исходящие параметры будут представлены в виде JSON-объекта, содержащего символы и частоту их встречи во входящих данных;
* Каждый символ будет представлен в виде поля JSON-объекта с именем символа и значением частоты встречи в виде целого числа.

*Пример исходящих данных: { "w": 6, "f": 3, "l": 2,  "n": 1 }*

***Используйте Postman или аналогичные инструменты для отправки POST-запроса на URL /frequency с телом запроса в виде JSON-объекта, содержащего поле "inputString" со значением строки, для которой нужно вычислить частоту встречи символов.***

Пример запроса:

```
POST /frequency
Content-Type: application/json

{
  "inputString": "fffwwwwwwnll"
}
```

Пример ответа:

```
HTTP/1.1 200 OK 
Content-Type: application/json
{ "w": 6, "f": 3, "l": 2,  "n": 1 }
```

## Требования:
Перед использованием этого приложения Вам нужно установить и настроить:
* JDK 20;
* Gradle 8.2

## Сборка приложения

```bash
gradle clean build
```
ИЛИ
```bash
make build
```

## Запуск приложения на localhost

```bash
gradle bootRun
```
ИЛИ
```bash
make start
```

## Запуск тестов

```bash
gradle test
```
ИЛИ
```bash
make test
```

## Запуск статического анализатора(Линтера)

```bash
gradle checkstyleMain checkstyleTest
```
ИЛИ
```bash
make lint
```
