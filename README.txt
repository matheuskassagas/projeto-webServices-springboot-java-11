# springboot-java-11

Essa aplicação Spring boot web foi baseada para um simples e-commerce.
Cadastro de produdos, usuarios, categorias.
A entidade de usuário recebe simples atributos necessários para um cadastro,
o controlador de usuário recebe os dados enviando-os para a camada de serviço onde temos as validações,
se tudo estiver certo acontece a inserção no banco de dados h2, caso tenha algo errado, como uma pesquisa de um id
 que nao existe, estoura uma excessão. Na camada dos controladores o controlador de usuário pode criar,
buscar, atualizar e deletar um usuário. Quando chamamos o método POST para criar um usuário a aplicação
recebe no controlador como um usuário de requisição (DTO request), na camada de serviço transformamos
essas dados do usuário em uma entidade para o banco de dados.. Quando chamamos o método GET seja para 1
ou mais objetos a camada de serviço faz a busca no banco de dados e transforma essa entidade em um (DTO response),
isso é feito para poder entregar só aquilo que é necessário para quem esteja fazendo a busca. Os controladores
de produto e categoria são basicamente a mesma coisa, podemos criar, buscar, atualizar e deletar.
As classes (entidades) foram associadas umas as outras
