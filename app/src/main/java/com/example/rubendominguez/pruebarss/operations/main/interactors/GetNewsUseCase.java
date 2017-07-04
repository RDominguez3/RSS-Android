package com.example.rubendominguez.pruebarss.operations.main.interactors;

import com.example.rubendominguez.pruebarss.data.model.RSS;

public interface GetNewsUseCase {

    interface Callback {
        void onNewsReceived(RSS rss);

        void onErrorReceived();
    }

    void execute(Callback callback);
}
