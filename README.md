# Film_API
Решение для удобного сбора информации о фильме в гугле и дальнейшего использования их в вашем проекте.

Пример команд :

        System.out.println(GoogleFilmPage.FilmYear("тупой и еще тупее")); // получаем год
        
        System.out.println(GoogleFilmPage.FilmGenre("третий лишний")); // получаем жанр
        
        System.out.println(GoogleFilmPage.FilmPoster("миллион способов потерять голову")); // получаем постер фильма
        
        System.out.println(GoogleFilmPage.FilmName("Джанго освобождённый")); // получаем название
        
        System.out.println(GoogleFilmPage.FilmPlot("12 лет рабства")); // получаем сюжет

        ArrayList<String> arr = GoogleFilmPage.FilmActorsAndSameFilms("миллион способов потерять голову");
        System.out.println(arr); // а также получаем список актеров и похожие фильмы
