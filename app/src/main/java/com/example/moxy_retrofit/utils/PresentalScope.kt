package com.example.moxy_retrofit.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


@DelicateCoroutinesApi
 object PresentalScope : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = EmptyCoroutineContext
}


/*
CoroutineDispatcher — отправляет работу в соответствующий поток.
Job — управляет жизненным циклом сопрограммы.
CoroutineName — имя сопрограммы, полезное для отладки.
CoroutineExceptionHandler — обрабатывает неперехваченные исключения.*/
