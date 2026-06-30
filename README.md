# Maquina de Cafe TDD

Proyecto desarrollado con Test-Driven Development (TDD) en Java, gestionado en NetBeans.
Simula una maquina dispensadora de cafe con seleccion de tamano de vaso y cantidad de azucar.

## Historia de Usuario

**Como:** Consumidor de cafe
**Deseo:** Tomar un vaso de cafe
**Para:** Mitigar el sueno

**Criterios de aceptacion:**
- Podre seleccionar entre 3 tamanos de vaso (Pequeno, Mediano, Grande)
- Podre seleccionar la cantidad de azucar
- Se muestra un mensaje si no hay vasos, azucar o cafe disponible

## Estructura del proyecto

```
src/com/itla/maquinacafe/
├── Azucarero.java
├── Cafetera.java
├── MaquinaDeCafe.java
└── Vaso.java

test/com/itla/maquinacafe/
├── TestAzucarero.java
├── TestCafetera.java
├── TestMaquinaDeCafe.java
└── TestVaso.java
```

## Tecnologias

- Java
- JUnit 4.13.2
- Hamcrest 1.3
- NetBeans (Ant)
- GitHub Actions (CI)

## Ejecutar las pruebas

Desde NetBeans: clic derecho sobre el proyecto > **Test**.

## CI/CD

El repositorio incluye un workflow en `.github/workflows/ci-pipeline.yml` que compila el
proyecto y ejecuta las 10 pruebas unitarias automaticamente en cada `push` o `pull_request`.
El resultado puede verse en la pestana **Actions** del repositorio.