package br.com.ajchagas.technewsapi.repository

open class Resource<T>(
    val dado: T?,
    val erro: String? = null
)

class SucessoResource<T>(dado: T) : Resource<T>(dado)

class FalhaResourc<T>(erro: String) : Resource<T>(dado = null, erro = erro)