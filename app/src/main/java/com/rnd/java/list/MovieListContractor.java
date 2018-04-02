package com.rnd.java.list;

public interface MovieListContractor {

    interface MovieListView {
        public void initAndSetListn();
        public void getListOfMovie(MovieResponse movieResponse);
    }

    interface MoviePresenter {
        public void wsCalling();
    }


}
