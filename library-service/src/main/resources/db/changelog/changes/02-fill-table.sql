INSERT INTO book_loan (book_id, took_at, due_to)
VALUES
    (1, NOW() - INTERVAL '30 days', NOW()),
    (2, NOW() - INTERVAL '30 days', NOW()),
    (3, NOW() - INTERVAL '30 days', NOW()),
    (4, NOW(), NOW() + INTERVAL '30 days'),
    (5, NOW(), NOW() + INTERVAL '30 days'),
    (6, NOW(), NOW() + INTERVAL '30 days'),
    (7, NOW(), NOW() + INTERVAL '30 days');
