# Bootstrap Builder

[![Build Status](https://travis-ci.com/przemekxa/BootstrapBuilder.svg?branch=main)](https://travis-ci.com/przemekxa/BootstrapBuilder)

Aplikacja dla programistów webowych, którzy chcą szybko utworzyć szkielet aplikacji z wykorzystaniem frameworka Bootstrap 4. Program pozwala na zwrócenie kodu strony z nagłówkiem, stopką, a także odpowiednimi tagami META w kontekście SEO zwykłego, Open Graph i Twittera. Aplikacja będzie dostępna poprzez GUI, a także jako zdalne API, dzięki czemu można ją zintegrować z istniejącymi narzędziami.

### Wejście
Wejście powinno zawierać:
- informację o tym, czy powinien być nagłówek i w jakiej wersji ("static" lub "fixed")
- informację o tym, czy powinna być stopka
- wartości tagów META: `title`, `type`, `description`, `image` (do ustalenia)
- typ tagów META SEO: zwykłe, Open Graph, Twitter
