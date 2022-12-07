CREATE DATABASE veterinaria;
-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-12-2022 a las 00:10:02
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animales`
--

CREATE TABLE `animales` (
  `idmascota` int(255) NOT NULL,
  `Cliente` int(11) DEFAULT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Raza` varchar(255) NOT NULL,
  `Color` varchar(255) NOT NULL,
  `Edad` int(8) NOT NULL,
  `Tamaño` varchar(255) NOT NULL,
  `Descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `animales`
--

INSERT INTO `animales` (`idmascota`, `Cliente`, `Nombre`, `Raza`, `Color`, `Edad`, `Tamaño`, `Descripcion`) VALUES
(1, 20860134, 'alfredo', 'ballena', 'amarillo', 5000, 'chico', 'esta curiosa'),
(2, 20860134, 'as', 'fds', 'dfs', 43, 's', 'sdf'),
(3, 20860134, 'as', 'fds', 'dfs', 43, 's', 'sdf'),
(4, 20860134, 'as', 'fds', 'dfs', 43, 's', 'sdf'),
(5, 20860134, 'm', 'm', 'm', 1, 'm', 'm'),
(14, 20860134, 'alfredo', 'ballena', 'amarillo', 5000, 'chico', 'esta curiosa'),
(15, 20860134, 'rtuytrety', 'jhgjhg', 'jhgjh', 34, 'jhgjg', 'jhgjh'),
(32, 20860134, 'rtuytrety', 'jhgjhg', 'jhgjh', 34, 'jhgjg', 'jhgjh'),
(87, 20860134, 'rtuytrety', 'jhgjhg', 'jhgjh', 34, 'jhgjg', 'jhgjh'),
(322113, 20860134, 'rtuytrety', 'jhgjhg', 'jhgjh', 34, 'jhgjg', 'jhgjh');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(8) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `Edad` varchar(255) NOT NULL,
  `FechaDeNacimiento` varchar(255) NOT NULL,
  `Sexo` varchar(255) NOT NULL,
  `Telefono` varchar(255) NOT NULL,
  `Colonia` varchar(255) NOT NULL,
  `Ciudad` varchar(255) NOT NULL,
  `Estado` varchar(255) NOT NULL,
  `CP` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Nombre`, `Apellidos`, `Edad`, `FechaDeNacimiento`, `Sexo`, `Telefono`, `Colonia`, `Ciudad`, `Estado`, `CP`, `Email`) VALUES
(0, 'John', 'Matt', '7', 'ayer', 'mucho', '12345678', 'china', 'morelos', 'tlaxcala', '27400', 'mamito@gmail.com'),
(1, 'as', '', '', '', '', '', '', '', '', '', ''),
(7, 'John', 'Matt', '7', 'ayer', 'mucho', '3', 'china', 'morelos', 'tlaxcala', '23', 'mamito@gmail.com'),
(2086013, 'John', 'Matt', '7', 'ayer', 'mucho', '12345678', 'china', 'morelos', 'tlaxcala', '27400', 'mamito@gmail.com'),
(20860134, 'John', 'Matt', '7', 'ayer', 'mucho', '12345678', 'china', 'morelos', 'tlaxcala', '27400', 'mamito@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `id` int(11) NOT NULL,
  `id_pro` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`id`, `id_pro`, `cantidad`, `precio`, `id_venta`) VALUES
(61, 4, 1, '5.00', 61),
(62, 4, 2, '5.00', 62);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `idEmpleado` int(8) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `edad` int(2) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `telefono` int(25) NOT NULL,
  `Colonia` varchar(255) NOT NULL,
  `Ciudad` varchar(255) NOT NULL,
  `Estado` varchar(255) NOT NULL,
  `CodigoPostal` int(8) NOT NULL,
  `puesto` varchar(255) NOT NULL,
  `Horario` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `NumeroSeguro` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`idEmpleado`, `Nombre`, `apellidos`, `edad`, `sexo`, `telefono`, `Colonia`, `Ciudad`, `Estado`, `CodigoPostal`, `puesto`, `Horario`, `Email`, `NumeroSeguro`) VALUES
(1, 'a', 'a', 2, 'a', 2, 'a', 'a', 'a', 2, 'z', 'z', 'z', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `Proveedor` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `Tipo` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idproducto`, `nombre`, `Proveedor`, `cantidad`, `precio`, `Tipo`, `descripcion`) VALUES
(4, 'pelota', 123, 0, '5.00', 'producto', 'pelota'),
(5, 'tenis', 123, 55, '66.00', 'producto', 'pelota'),
(6, 'tenis', 123, 55, '66.00', 'producto', 'pelota');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provedores`
--

CREATE TABLE `provedores` (
  `IdProveedor` int(8) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `Telefonos` varchar(255) NOT NULL,
  `Correo` varchar(255) NOT NULL,
  `Colonia` varchar(255) NOT NULL,
  `Ciudad` varchar(255) NOT NULL,
  `Estado` varchar(255) NOT NULL,
  `CP` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `provedores`
--

INSERT INTO `provedores` (`IdProveedor`, `Nombre`, `Apellidos`, `Telefonos`, `Correo`, `Colonia`, `Ciudad`, `Estado`, `CP`) VALUES
(123, 'aa', 'andres', '44444', 'a@gmail.com', 'pluton', 'lerdo', 'coyote', 28054);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `rol` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `pass`, `rol`) VALUES
(20860054, 'Miguel', 'miguel@gmail.com', '1234', 'Administrador'),
(20860055, '', 'eddy.jisus@gmail.com', '1234', 'Administrador'),
(20860056, '', 'maov@gmail.com', '1234', 'Asistente'),
(20860057, '', 'miguel1@gmail.com', '1234', 'Asistente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `cliente` int(11) NOT NULL,
  `vendedor` varchar(60) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `fecha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id`, `cliente`, `vendedor`, `total`, `fecha`) VALUES
(61, 20860134, 'Miguel', '5.00', '06/12/2022 09:54:18.175'),
(62, 20860134, 'Miguel', '10.00', '06/12/2022 10:38:23.15');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `animales`
--
ALTER TABLE `animales`
  ADD PRIMARY KEY (`idmascota`),
  ADD KEY `IdCliente` (`Cliente`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pro` (`id_pro`),
  ADD KEY `id_venta` (`id_venta`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idproducto`),
  ADD KEY `Proveedor` (`Proveedor`);

--
-- Indices de la tabla `provedores`
--
ALTER TABLE `provedores`
  ADD PRIMARY KEY (`IdProveedor`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente` (`cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `animales`
--
ALTER TABLE `animales`
  MODIFY `idmascota` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=322114;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `idEmpleado` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20860058;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `animales`
--
ALTER TABLE `animales`
  ADD CONSTRAINT `animales_ibfk_1` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`IdCliente`),
  ADD CONSTRAINT `animales_ibfk_2` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`IdCliente`);

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`id_pro`) REFERENCES `productos` (`idproducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detalle_ibfk_2` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`Proveedor`) REFERENCES `provedores` (`IdProveedor`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
