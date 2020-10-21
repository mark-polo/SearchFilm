# Search Film API

Решение для удобного сбора информации о фильме в гугле , а также для вывода информации о фильме с IMDB страницы фидьма с исрользованием OMDB API. К тому же 
имеется рекомендаци по искомым фильмам и поиск по ключевому слову.

Как использовать api , для этого вам понадобится устаеёновить его используя maven  :

        <dependency>
            <groupId>org.filmi</groupId>
            <artifactId>search-film-api</artifactId>
            <version>1.0</version>
        </dependency>

Пример использования комманд :

Поиск иформации о фильме в гугл странице фильма. Здесь собираются данные такие , как год , жанр , название , рейтинг и т.д.

        String filmYear = GoogleFilmPage.FilmYear("Your film_name");
        String filmTitle = GoogleFilmPage.FilmName("Your film_name");
        String filmGenre = GoogleFilmPage.FilmGenre("Your film_name");
        String filmRatings = GoogleFilmPage.FilmRatings("Your film_name");
        String filmPlot = GoogleFilmPage.FilmPlot("Your film_name");
        ArrayList<String> filmActorsAndSameFilms = GoogleFilmPage.FilmActorsAndSameFilms("Your film_name");
        
От 0 index до 4 index идут актеры , от 5 и до 9 соответственно идут похожие фильмы 

        String sameFilms = filmActorsAndSameFilms.get(5);
        String filmPoster = GoogleFilmPage.FilmPoster("your film_name");
        
Информация о фильме из сайта IMDb с использованием OMDB API. В api есть 2 вида инфы из сайта IMDb : первая рандомная , то есть без ввода названия фильма как это было в гугл инфе о фильме , вторая же нужно вводить название фидьма.

        IMDBModel model = new IMDBModel();
        String randomFilmIMDB = RandomFilmWithInforFromIMDBUseOMDbAPI.film(model , "your omdb api key" , 0 , 100 , 3 , 1);
        
IMDBModel - это модель фильма , то есть там получается инфа(setter) о режисере , названию фильма , рейтингу и т.д. потом выводится(getter)
your omdb api key - это api ключ который получается на сайте http://www.omdbapi.com

minIndexOfRandom и maxIndexOfRandom - необходимы для рандомного выбора страницы

countOfPages - мы получаем из сайта IMDb базовые 50 страниц , а дальше циклом добовляем по страницы , то есть если countOfPages будем равен 20 - то и страниц в итоге будет +20 , но есть и проблема - чем больше countOfPages , тем дольше обрабатывается.

index - для простоты использования если , например , нужен только рейтинг фильма или жанр используется index , который по сути является индексом ArrayList

Вторый тип инфы о фильмы из сайта IMDb - не рандомный способ , тут все как и в предыдущем только без minIndexOfRandom и maxIndexOfRandom , а также countOfPages

        IMDBModel model = new IMDBModel();
        
        String imdbFilm = IMDbFilmUseOMDbAPI.IMDbFilm(model , "your api key" , "film_name" , 4);
        
Как видно все такое же только вместо minIndexOfRandom , maxIndexOfRandom и countOfPages появился film_name

Рекомендациии и поиск по ключевому слову.

        ArrayList<String> key = new ArrayList<>();
        key.add("ужасы");

        String rec = Recommendation.filmRec("film_name" , key);
        
key - это и есть поиск по ключевому слову , пока что только по-одному.
