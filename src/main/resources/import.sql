insert into tb_contatos(id,nome,email,fone)values(1,'maria','maria@gmail.com','(47)9809-0987');
insert into tb_contatos(id,nome,email,fone)values(2,'jose','jose@gmail.com','(47)9809-0987');
insert into tb_contatos(id,nome,email,fone)values(3,'joao','joao@gmail.com','(47)9809-0987');

insert into tb_compromissos(id,descricao,data,hora,contato_id)values(10, 'Jogar bocha','2023-12-11','15:00:00',1);
insert into tb_compromissos(id,descricao,data,hora,contato_id)values(20, 'pescar','2023-10-11','15:00:00',2);

insert into tb_user(nome, email, senha)values('maria','maria@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
insert into tb_user(nome, email, senha)values('joana','joana@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
insert into tb_user(nome, email, senha)values('Antonia','antonia@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


insert into tb_role(authority)values('ROLE_USUARIO');
insert into tb_role(authority)values('ROLE_ADMIN');
insert into tb_role(authority)values('ROLE_OPERADOR');


insert into tb_user_role(user_id,role_id)values(1,1);
insert into tb_user_role(user_id,role_id)values(2,2);
insert into tb_user_role(user_id,role_id)values(3,2);