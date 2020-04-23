package com.travel.travelapi.controllers

import com.travel.travelapi.models.Category
import com.travel.travelapi.models.CategoryPlace
import com.travel.travelapi.models.Place
import com.travel.travelapi.services.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/place")
class PlaceController(@Autowired private val service: PlaceService,
                      @Autowired private val categoryController: CategoryPlaceController,
                      @Autowired private val workingScheduleService: WorkingScheduleController,
                      @Autowired private val parkingService: ParkingController,
                      @Autowired private val reviewService: ReviewController){


    /**
     * @return all places
     * @param full if given true returns places mapped with categories, parking, reviews, schedule otherwise just general info
     *
     */
    @GetMapping("/all")
    fun parking(@RequestParam full: Boolean = false): List<Place> {
        val places: List<Place> = service.selectAll()
            if(full){
                for (value: Place in places) {
                    value.categories = categoryController.getCategoriesById(value.placeId!!)
                    value.parking = parkingService.getParkingLocationsById(value.placeId)
                    value.reviews = reviewService.getReviewsById(value.placeId)
                    value.schedule = workingScheduleService.getWorkingScheduleById(value.placeId)
                }
            }
        return places
    }
}