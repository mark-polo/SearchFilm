# Film_API
Решение для удобного сбора информации о фильме в гугле и дальнейшего использования их в вашем проекте.

Пример команд :

        System.out.println(GoogleFilmPage.FilmYear("тупой и еще тупее"));
        
        System.out.println(GoogleFilmPage.FilmGenre("третий лишний"));
        
        System.out.println(GoogleFilmPage.FilmPoster("миллион способов потерять голову"));
        
        System.out.println(GoogleFilmPage.FilmName("Джанго освобождённый"));
        
        System.out.println(GoogleFilmPage.FilmPlot("12 лет рабства"));

        ArrayList<String> arr = GoogleFilmPage.FilmActorsAndSameFilms("миллион способов потерять голову");
        System.out.println(arr);
