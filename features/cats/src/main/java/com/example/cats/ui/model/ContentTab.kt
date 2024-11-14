package com.example.cats.ui.model

enum class ContentTab(val orderParam: String) {
    Latest("DESC"),
    Newest("ASC"),
    Random("RANDOM"),
    Favorite("")
}