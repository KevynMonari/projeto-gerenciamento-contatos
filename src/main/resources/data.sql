INSERT INTO grupos (nome, descricao) VALUES 
('Família', 'Membros da família'),
('Trabalho', 'Colegas de trabalho'),
('Escola', 'Amigos da escola'),
('Amigos', 'Amigos em geral');

INSERT INTO contatos (nome, email, telefone, endereco, data_nascimento, observacoes, grupo_id) VALUES 
('João Silva', 'joao@email.com', '11999999999', 'Rua A, 123', '1990-05-15', 'Primo', 1),
('Maria Santos', 'maria@email.com', '11888888888', 'Av B, 456', '1985-10-20', 'Colega de trabalho', 2);