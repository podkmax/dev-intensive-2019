package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {
    abstract fun formatMessage(): String
    companion object AbstractFactory {
        var id = -1
        fun makeMessage(from: User?, chat: Chat, date: Date = Date(), type: String, payload: Any) : BaseMessage {
            id++
            return when(type) {
                "image" -> ImageMessage("$id", from, chat, date = date, image = payload as String)
                    else -> TextMessage("$id", from, chat, date = date, text = payload as String)
            }
        }
    }
}