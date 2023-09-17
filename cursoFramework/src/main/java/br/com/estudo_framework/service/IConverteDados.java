package br.com.estudo_framework.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
