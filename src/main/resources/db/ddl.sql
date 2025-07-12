CREATE TABLE vote_items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    count INT DEFAULT 0
);
CREATE TABLE vote_record (
    id INT AUTO_INCREMENT PRIMARY KEY,
    voter_name VARCHAR(100) NOT NULL,
    vote_item_id INT NOT NULL,
    vote_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (vote_item_id) REFERENCES vote_item(id)
);