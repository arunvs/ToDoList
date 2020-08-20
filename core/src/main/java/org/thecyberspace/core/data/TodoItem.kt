package org.thecyberspace.core.data

data class TodoItem(
    var title:String,
    var content:String,
    var creationTime:Long,
    var updateTime:Long,
    var id:Long = 0L
)