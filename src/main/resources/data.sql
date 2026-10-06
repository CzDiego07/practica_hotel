-- 1. INSERCIÓN DE TIPOS DE HABITACIÓN (5 Registros)
INSERT INTO tipo_habitacion (nombre, capacidad, descripcion, precio_base) VALUES
('Sencilla Standard', 1, 'Habitación individual básica con cama matrimonial y escritorio.', 850.00),
('Doble Deluxe', 2, 'Habitación con dos camas individuales o una King, ideal para parejas o ejecutivos.', 1400.00),
('Suite Ejecutiva', 2, 'Suite con área de estar independiente, vista panorámica y escritorio de trabajo.', 2200.00),
('Familiar Premium', 4, 'Habitación espaciosa con dos camas Queen, pequeña cocineta y balcón.', 2800.00),
('Master Suite Presidencial', 4, 'Cama King, jacuzzi, terraza privada, sala de juntas y vista al mar.', 5000.00);

-- 2. INSERCIÓN DE HOTELES (2 Registros)
INSERT INTO hoteles (nombre, direccion, ciudad, telefono, email, activo) VALUES
('Hotel Paraíso Central', 'Av. Paseo de la Reforma 123, Col. Centro', 'Ciudad de México', '5551234567', 'contacto@paraisocentral.com', true),
('Hotel Paraíso Pacífico', 'Blvd. Costero Miguel Alemán 456, Zona Hotelera', 'Acapulco', '7449876543', 'reservas@paraisopacifico.com', true);

-- 3. INSERCIÓN DE HABITACIONES (10 Registros)
-- id_hotel: 1 (Paraíso Central), 2 (Paraíso Pacífico)
-- id_tipo: 1 (Sencilla), 2 (Doble), 3 (Suite Ej), 4 (Familiar), 5 (Master Suite)
INSERT INTO habitaciones (numero, piso, estado, id_hotel, id_tipo) VALUES
-- Hotel 1: Paraíso Central (5 habitaciones)
('101', 1, 'Disponible', 1, 1),
('102', 1, 'Disponible', 1, 2),
('201', 2, 'Mantenimiento', 1, 2),
('202', 2, 'Disponible', 1, 3),
('301', 3, 'Ocupado', 1, 5),

-- Hotel 2: Paraíso Pacífico (5 habitaciones)
('101', 1, 'Disponible', 2, 1),
('102', 1, 'Mantenimiento', 2, 2),
('201', 2, 'Disponible', 2, 3),
('301', 3, 'Disponible', 2, 4),
('401', 4, 'Ocupado', 2, 5);