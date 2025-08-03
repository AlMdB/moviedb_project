# Movie DB Android App

Uma aplicação Android moderna para explorar filmes populares usando a API do The Movie Database (TMDB), desenvolvida com Jetpack Compose e seguindo as melhores práticas de arquitetura Android

##

![image]()
![image]()


Projeto utilizando **arquitetura MVVM**, buscou-se separar o projeto em camadas para melhor compreensão

- **UI Layer**: Com jetpack compose
- **Domain Layer**: View Models com hilt
- **Data Layer**: Repository pattern para API REST e possivel update para cache local
- **NetWork Layer** Retrofit para comunicacao api

Essa configuração foi escolhida pois facilita futuras mudanças ao isolar responsabilidades dos componentes.
MVVM por ser a mais utilizada, com melhor testabilidade, reatividade a mudanças no componentes.
Dagger Hilt para injeção de dependência e melhor detecção de erros,na compilação.
Compose: Menos verbosidade comparado ao xml e adaptado para novas versões com melhor compilação e performance.
Retrofit: Facilita o uso de API Rest em interfaces kotlin

### Estrutura do Projeto

├── data/
│   ├── api/           # Interface Retrofit e DTOs
│   ├── models/        # Modelos de dados
│   ├── mappers/       # Conversão DTO -> Domain
│   └── repository/    # Implementação do Repository
├── di/                # Módulos do Hilt
├── movieDetails/
├── ui/
│   ├── presentation/  # ViewModels e Estados
│   ├── theme/         # Tema e cores
├── utils/             # Classes utilitárias
├── App.kt
└── MainActivity.kt    # Activity principal



## Como Executar

### Pré-requisitos
- Android Studio Hedgehog | 2023.1.1 ou superior
- JDK 17
- SDK Android 35 (API level 35)
- Conta no [The Movie Database (TMDB)](https://www.themoviedb.org/)

### Setup

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seuusuario/sidia-moviedb.git
   cd sidia-moviedb

2. **Configure Chave API do movieDB**:
    - Criar conta no TMDB
    - Gerar chave API
    - Inserir a chave api no arquivo **local.properties**
    
    ```local.properties
    TMDB_API_KEY=sua_api_key_aqui
3. **Abra o projeto no android Studio**
    - Aguarde o sync do Gradle
4. **Build**
    - Clique em Build ou Shift +F10





## Futuras Mudanças
    - Melhorar UI
    - Adicionar Testes Unitários
    - Melhorar consultas a mais tipos de filmes ou filtro para certas categorias (Ex. Terror, Ação, etc)
    - Mensagens de Log.d para verificar os motivos de falhas de algumas imagens
    - Criar um sistema de Cache/ Banco de Dados locais para permitir o funcitonamento do App offline
    - Imagens demoram pra carregar as vezes

