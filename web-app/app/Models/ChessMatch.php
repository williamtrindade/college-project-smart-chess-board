<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Collection;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

/**
 * Class Match
 * @package App\Models
 *
 * @property Collection $moves
 */
class ChessMatch extends Model
{
    use HasFactory;

    protected $table = 'chess_matches';

    protected $fillable = [
        'name',
        'winner',
    ];

    const WHITE_WINNER = 1;
    const BLACK_WINNER = 2;

    /**
     * @return HasMany
     */
    public function moves(): HasMany
    {
        return $this->hasMany(Move::class,'chess_match_id','id');
    }

    /**
     * @param $value
     * @return string
     */
    public function getWinnerAttribute($value): string
    {
        if ($value) {
            return $value == self::WHITE_WINNER ? 'White' : 'Black';
        }
        return 'Playing';
    }
}
