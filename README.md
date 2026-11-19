# ifgram

### Relacionamento: Post e Autor

Como se trata de post, o relacionamento corresponde a `@ManyToOne`, pois vários posts podem pertencer ao mesmo autor (a um único autor). 

No mais, a tabela `tb_post` é quem guarda a chave estrangeira, principalmente pelo relacionamento entre post e autor, visto que um mesmo autor pode fazer vários posts (1:N)
