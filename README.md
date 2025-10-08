# Android Kotlin Skeleton Project - Interview Code

This is a minimal Android application built with Kotlin, MVVM architecture, and Clean Architecture principles. The app displays a list of data and allows users to view data details.

## Project Structure

```
app/
├── domain/                 # Business logic layer
│   ├── model/             # Domain entities
│   ├── repository/        # Repository interfaces
│   └── usecase/           # Use cases
├── data/                  # Data layer
│   ├── datasource/        # Data sources
│   └── repository/        # Repository implementations
├── presentation/          # Presentation layer
│   ├── list/              # List screen
│   └── detail/            # Detail screen
└── di/                    # Dependency injection
```

## Architecture

- **MVVM**: Model-View-ViewModel pattern for UI layer
- **Clean Architecture**: Separation of concerns with domain, data, and presentation layers
- **LiveData**: For observable data patterns
- **Coroutines**: For asynchronous operations
- **Repository Pattern**: Abstract data sources

## License

This is a skeleton project for interview purposes.
