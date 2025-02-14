-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS DbClockHub;
USE DbClockHub;

-- Tabela `usuario`
CREATE TABLE IF NOT EXISTS usuario (
    cdUsuario INT AUTO_INCREMENT PRIMARY KEY, -- ID do usuário (chave primária)
    username VARCHAR(50) NOT NULL UNIQUE,     -- Nome de usuário (único)
    password VARCHAR(255) NOT NULL           -- Senha do usuário
);

-- Tabela `ponto`
CREATE TABLE IF NOT EXISTS ponto (
    cdPonto INT AUTO_INCREMENT PRIMARY KEY,       -- ID do registro de ponto (chave primária)
    cdUsuario INT NOT NULL,                  -- ID do usuário (chave estrangeira)
    nomeUsuario VARCHAR(50) NOT NULL,        -- Nome do usuário
    horaDoPonto TIME NOT NULL,               -- Hora do registro do ponto
    diaDoPonto DATE NOT NULL,                -- Dia do registro do ponto
    FOREIGN KEY (cdUsuario) REFERENCES usuario(cdUsuario) -- Relação com a tabela `usuario`
);

-- Exemplo de inserção de dados (opcional)
-- Inserir um usuário
INSERT INTO usuario (username, password) VALUES ('admin', 'senha123');

-- Inserir um registro de ponto
/*INSERT INTO ponto (usuarioId, nomeUsuario, horaDoPonto, diaDoPonto)
VALUES (1, 'admin', '08:00:00', '2023-10-01');*/