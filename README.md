# Cats App

Cats App is an Android application that displays information about different cat breeds using [The Cat API](https://thecatapi.com). 

## Features

- **List of Cats**: Displays a list of cats with an image, breed name, and country of origin.
- **Breed Details**: Tapping on a breed opens a detailed view with additional information, including the breed’s country, description, and temperament.
- **Favourites**: Allows users to ‘favourite’ a cat breed.

![cats app](https://github.com/user-attachments/assets/9edd398c-30a7-4bcd-a3a5-8375a527975e)

## Technologies

- **Jetpack Compose**
- **Kotlin Coroutines & Flow**
- **Retrofit**
- **Jetpack ViewModel**
- **Paging 3**
- **Jetpack Navigation**
- **Room**

## Project Structure

- **:app**: the main application module.
- **:core:data**: data handling logic, including data repositories.
- **:core:cats-api**: handles API interactions with The Cat API, managing network requests.
- **:core:database**: manages the local database setup.
- **:features:cats**: the main feature for displaying the list of cats and breed details.
