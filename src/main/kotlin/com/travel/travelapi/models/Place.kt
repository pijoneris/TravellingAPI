package com.travel.travelapi.models

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
abstract class Place (var name: String? = null,
                  var description: String? = null,
                  //var placeId: Int? = null,
                  var averageTimeSpent: String? =  null,
                  var latitude: Float? = null,
                  var longitude: Float? = null,
                  var address: String? = null,
                  var country: String? = null,
                  var city: String? = null,
                  var phoneNumber: String? = null,
                  var website: String? = null){

    var categories: List<Category>? = null
    var parking: List<Parking>? = null
    var reviews: List<Review>? = null
    var schedule: List<WorkingSchedule>? = null
    var photos: List<Photo>? = null
    var tags: List<Tag>? = null

}
