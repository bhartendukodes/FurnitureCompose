package com.example.navigationandpaging.models.Notification

data class Inbox(
    val id: String,
    val title: String,
    val image: String?,
    val body: String,
    val tag: String,
    val unRead: Boolean,
    val dateTime: String,
    val inboxType: InboxType
)

enum class InboxType {
    ORDER_UPDATE,
    NEWS,
    CART_UPDATE,
    FEATURED_PRODUCT,
    OFFER
}