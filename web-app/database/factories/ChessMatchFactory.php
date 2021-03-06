<?php

namespace Database\Factories;

use App\Models\ChessMatch;
use Illuminate\Database\Eloquent\Factories\Factory;

class ChessMatchFactory extends Factory
{
    /**
     * The name of the factory's corresponding model.
     *
     * @var string
     */
    protected $model = ChessMatch::class;

    /**
     * Define the model's default state.
     *
     * @return array
     */
    public function definition(): array
    {
        return [
            'name' => $this->faker->name . '(W) VS (B)' . $this->faker->name,
        ];
    }
}
